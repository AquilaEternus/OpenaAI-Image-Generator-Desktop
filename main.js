const { app, BrowserWindow, Menu } = require("electron");
const path = require("path");

const createWindow = () => {
  const win = new BrowserWindow({
    width: 800,
    height: 650,
    webPreferences: {
      preload: path.join(__dirname, "util/preload.js"),
      devTools: false,
    },
  });

  Menu.setApplicationMenu(null);

  win.loadFile("index.html");
};

app.whenReady().then(() => {
  createWindow();

  app.on("activate", () => {
    if (BrowserWindow.getAllWindows().length === 0) {
      createWindow();
    }
  });
});

app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    app.quit();
  }
});
