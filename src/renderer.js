const prompt = document.querySelector("#prompt");
const size = document.querySelector("#size");
const image = document.querySelector("#image");

document.querySelector("#form").addEventListener("submit", submitPrompt);
size.addEventListener("change", sizeChange);

/* Displays image upon successful request. Otherwise, display an error to the user. */
function submitPrompt(e) {
  e.preventDefault();

  const promptText = prompt.value;
  const sizeOption = size.value;

  /* Clear UI of previous request and show loading spinner. */
  clearFields();
  removeError();
  showSpinner();

  /* Display error and exit function if prompt is invalid. */
  if (!validPrompt(promptText)) {
    showError("Prompt is not valid.");
    removeSpinner();
    return;
  }

  /* Call backend API and request the image url */
  fetch(
    `https://openai-java-api-ae.herokuapp.com/api/v1/images?prompt=${promptText}&size=${sizeOption}`,
    {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    }
  )
    .then((response) => response.json())
    .then((data) => {
      removeSpinner();
      image.src = data[0].url;
    })
    .catch((err) => {
      removeSpinner();
      image.src = `http://via.placeholder.com/${sizeOption}`;
      if (err.message === "Failed to fetch") {
        showError("Connection to server is down.");
      } else {
        showError(err.message);
      }
    });
}

/* Returns boolean value determining if prompt value is valid. */
function validPrompt(prompt) {
  if (!prompt.length || prompt === null) {
    return false;
  }
  return true;
}

/* Add show class to error container for the duration of 4 seconds. */
function showError(message) {
  const error = document.getElementById(`error`);
  error.innerText = message;
  error.classList.add("show");
  setTimeout(() => {
    error.innerText = "";
    error.classList.remove("show");
  }, 4000);
}

/* Remove show class from error container. */
function removeError() {
  const error = document.getElementById(`error`);
  error.classList.remove("show");
}

/* Add show class to spinner container. */
function showSpinner() {
  const spinnerContainer = document.querySelector(".spinner-container");
  spinnerContainer.classList.add("show");
}

/* Remove show class from spinner container. */
function removeSpinner() {
  const spinnerContainer = document.querySelector(".spinner-container");
  spinnerContainer.classList.remove("show");
}

/* Clear prompt and remove current image source. */
function clearFields() {
  // prompt.value = "";
  image.src = "";
}

/* Change place holder image depending on the size */
function sizeChange(e) {
  image.src = `http://via.placeholder.com/${e.target.value}`;
}
