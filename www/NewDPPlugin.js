var newDPPlugin = {
  conectar: function (success, error) {
    var options = {};
    cordova.exec(success, error, 'NewDPPlugin', 'conectar', [options]);
  },
  capturar: function (success, error) {
    var options = {};
    cordova.exec(success, error, 'NewDPPlugin', 'capturar',[options])
  }
}

cordova.addConstructor(function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.NewDPPlugin = NewDPPlugin;
  return window.plugins.NewDPPlugin;
});