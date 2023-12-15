module.exports = {
  "presets": [
    [
      "@babel/preset-env",
      //指定要兼容的浏览器，以及版本
      {
        "targets": {
          "esmodules": true,
          "chrome": '60',
          "firefox": '60',
          "ie": '8',
          "safari": '10',
          "edge": '17'
        }
      }
    ]
  ],
  "plugins": [
    ["@babel/plugin-transform-runtime", {
      "corejs": 2,
    }],
    "@babel/transform-arrow-functions",
    "@babel/plugin-proposal-class-properties"
  ]
}
