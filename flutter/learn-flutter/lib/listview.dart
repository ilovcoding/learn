import 'package:flutter/material.dart';
class NewRouter extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'list 组件',
      home: Scaffold(
        appBar: new AppBar(title: new Text('listView Widget')),
        //纵向列表代码
        // body: ColumnList(),
        //横向列表代码
        // body: Center(
        //   child: Container(height: 200.0, child: RowList()),
        // ),
        //动态list
        // body: TrendList()
        //网格list
        body: GridViewList(),
      ),
    );
  }
}

class ColumnList extends StatelessWidget {
  //纵向列表代码

  @override
  Widget build(BuildContext context) {
    return ListView(
      children: <Widget>[
        // new ListTile(
        //   leading: new Icon(Icons.perm_camera_mic),
        //   title: new Text('Icons.perm_camera_mic'),
        // ),
        // new ListTile(
        //   leading: new Icon(Icons.add_call),
        //   title: new Text('Icons.add_call'),
        // ),
        // new ListTile(
        //   leading: new Icon(Icons.access_time),
        //   title: new Text('Icons.acess_time'),
        // ),
        new Image.network(
            'http://img.netbian.com/file/2019/0208/small47434a0d2cb34a6a538f1986b8b071671549639095.jpg'),
        new Image.network(
            'http://img.netbian.com/file/2019/0212/db2b62a46fa60270428fddff4ebd4461.jpg'),
        new Image.network(
            'http://img.netbian.com/file/2019/0209/small056ff5cc8cbce876a6276c6befc16b761549723158.jpg')
      ],
    );
  }
}

class RowList extends StatelessWidget {
  //横向列表代码
  @override
  Widget build(BuildContext context) {
    return ListView(
      scrollDirection: Axis.horizontal, //横向(水平)
      children: <Widget>[
        new Container(
          width: 180.0,
          color: Colors.lightBlue,
        ),
        new Container(
          width: 180.0,
          color: Colors.redAccent,
        ),
        new Container(
          width: 180.0,
          color: Colors.yellow,
        ),
        new Container(
          width: 180.0,
          color: Colors.green,
        )
      ],
    );
  }
}

//声明一个数组
var list = new List<String>.generate(100, (i) => "Item $i");

class TrendList extends StatelessWidget {
  //动态列表
  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: list.length,
        itemBuilder: (context, index) {
          return new ListTile(
            title: new Text('${list[index]}'),
          );
        });
  }
}

class GridViewList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    //文本列
    // return GridView.count(
    //   padding: const EdgeInsets.all(20.0), //外框边距
    //   crossAxisSpacing: 10.0, //每个网格边距
    //   crossAxisCount: 4, //列数
    //   children: <Widget>[
    //     const Text('123'),
    //     const Text('456'),
    //     const Text('123'),
    //     const Text('456'),
    //     const Text('123'),
    //     const Text('456'),
    //   ],
    // );
    //图片列
    return GridView(
      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 3,
        mainAxisSpacing: 2.0,
        crossAxisSpacing: 2.0,
        childAspectRatio: 0.75, // 宽/高 0.75是3/4
      ),
      children: <Widget>[
        new Image.network(
            'http://img.netbian.com/file/2019/0208/small47434a0d2cb34a6a538f1986b8b071671549639095.jpg',fit: BoxFit.cover,),
        new Image.network(
            'http://img.netbian.com/file/2019/0212/db2b62a46fa60270428fddff4ebd4461.jpg',fit: BoxFit.cover),
        new Image.network(
            'http://img.netbian.com/file/2019/0209/small056ff5cc8cbce876a6276c6befc16b761549723158.jpg',fit: BoxFit.cover),
        new Image.network(
            'http://img.netbian.com/file/2019/0208/small47434a0d2cb34a6a538f1986b8b071671549639095.jpg',fit: BoxFit.cover),
        new Image.network(
            'http://img.netbian.com/file/2019/0212/db2b62a46fa60270428fddff4ebd4461.jpg',fit: BoxFit.cover),
        new Image.network(
            'http://img.netbian.com/file/2019/0209/small056ff5cc8cbce876a6276c6befc16b761549723158.jpg',fit: BoxFit.cover)
      ],
    );
  }
}
