//这是新页面
import 'package:flutter/material.dart';

class NewRouter extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    //stack布局
    var stack = new Stack(
      alignment: FractionalOffset(0.5,1),//相对位置
      children: <Widget>[
        new CircleAvatar(
          backgroundImage: new NetworkImage(
              'http://img.netbian.com/file/2019/0212/db2b62a46fa60270428fddff4ebd4461.jpg'),
          radius: 100.0,
        ),
        new Container(
          decoration: new BoxDecoration(
            color: Colors.red,
          ),
          padding: EdgeInsets.all(10.0),
          child: Text('photo from network'),
        )
      ],
    );
    //card 布局
    var card= new Card(
      child: Column(
        children: <Widget>[
          ListTile(
            title: new Text('title1.......',style: TextStyle(fontWeight: FontWeight.w500),),
            subtitle:new Text('subtitle1...............'),
            leading: Icon(Icons.account_balance,color: Colors.lightGreen,),
          ),
          new Divider(),
           ListTile(
            title: new Text('title2.......',style: TextStyle(fontWeight: FontWeight.w500),),
            subtitle:new Text('subtitle2...............'),
            leading: Icon(Icons.account_balance,color: Colors.lightGreen,),
          ),
          new Divider(),
           ListTile(
            title: new Text('title3.......',style: TextStyle(fontWeight: FontWeight.w500),),
            subtitle:new Text('subtitle3...............'),
            leading: Icon(Icons.account_balance,color: Colors.lightGreen,),
          ),
        ],
      )
    );
    return MaterialApp(
      title: 'list 组件',
      home: Scaffold(
        appBar: new AppBar(title: new Text('Row Widget')),
        // body: Center(
        //   child: stack,
        // ),
        body: card,
      ),
    );
  }
}
