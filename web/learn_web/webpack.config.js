const { join } = require('path')
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const { HotModuleReplacementPlugin } = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

// const typeScriptRules = {
//   test: /\.tsx?$/,
//   use: 'ts-loader',
//   exclude: /node_modules/
// }
// const babelRules = {
//   test: /\.js$/,
//   use: ['babel-loader'],
//   exclude: /node_modules/
// }
const babelTsRules = {
  test: /\.(t|j)sx?$/,
  use: ["babel-loader", "ts-loader"],
  exclude: [join(__dirname, "node_modules")]
}

module.exports = {
  // mode: 'production',
  mode: "development",
  entry: {
    index: join(__dirname, 'src', 'app')
  },
  devtool: 'inline-source-map',
  devServer: {
    port: 8081,
    contentBase: join(__dirname, 'dist'),
    hot: true,
    watchContentBase: true
  },
  output: {
    filename: '[name].js',
    path: join(__dirname, 'dist'),
    pathinfo: false
  },
  plugins: [
    new CleanWebpackPlugin(),
    new HtmlWebpackPlugin({
      template: join(__dirname, 'public', 'index.html'),
      // true或者body：所有JavaScript资源插入到body元素的底部
      // head: 所有JavaScript资源插入到head元素中
      // 所有静态资源css和JavaScript都不会注入到模板文件中
      inject: false //不配置会，两次刷新页面
    }),
    new HotModuleReplacementPlugin()
  ],
  module: {
    rules: [
      babelTsRules
    ]
  },
  resolve: {
    extensions: ['.tsx', '.ts', '.js']
  },
}