//这是新页面
import 'package:flutter/material.dart';

class NewRouter extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'widget组件',
      home: Scaffold(
        body: Center(
            child: Container(
          child: new Text(
            'container 组件',
            style: TextStyle(fontSize: 40.0),
          ),
          alignment: Alignment.topLeft,
          width: 500.0,
          height: 400.0,
          // color: Colors.lightBlue,
          padding: const EdgeInsets.fromLTRB(10.0,100.0,0.0,0.0),
          margin: const EdgeInsets.all(10.0),
          decoration: new BoxDecoration(
              //添加渐变
              gradient: const LinearGradient(
                colors: [Colors.lightBlue,Colors.purple,Colors.yellow,Colors.green]
              ),
              //添加 边框
              border: Border.all(width: 2.0,color: Colors.red) 
          ),
        )),
      ),
    );
  }
}
