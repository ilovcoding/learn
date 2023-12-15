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
            child: Image.network(
                'http://img.netbian.com/file/2019/0212/db2b62a46fa60270428fddff4ebd4461.jpg',
              
                // 图片颜色混合模式
                // color: Colors.yellowAccent,
                // colorBlendMode: BlendMode.modulate,
                //图片填充模式
                // fit:BoxFit.cover
                //fit:BoxFit.center
                //图片重复模式
                // repeat: ImageRepeat.repeatY,
                ),
            width: 300.0,
            height: 200.0,
            color: Colors.lightBlue,
          ),
        ),
      ),
    );
  }
}
