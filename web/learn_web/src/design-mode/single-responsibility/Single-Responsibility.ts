import { log } from 'util';
// import { version } from 'webpack';

// 方式一的run 方法中违反了 单一责任原则
class Vehicle {
  public run(vehicle: string): void {
    log(vehicle + "正在公路上运行")
  }
}
// 方案二 把各个功能不同的交通工具拆成不同类
class RoadVehicle {
  public run(vehicle: string): void {
    log(vehicle + '在陆地上运行')
  }
}
class AirVehicle {
  public run(vehicle: string): void {
    log(vehicle + '在空中运行')
  }
}
// 方案二需要改动的代码太多
// 方案三  在方法层面上实现 单一原则
class Vehicle3 {
  public run(vehicle: string): void {
    log(vehicle + "正在公路上运行")
  }
  public runAir(vehicle: string): void {
    log(vehicle + "正在天空运行")
  }
  public runWater(vehicle: string): void {
    log(vehicle + "在水中运行")
  }
}

export default class SingleResponsibility {
  public static main() {
    // 方案1
    let vehicle = new Vehicle()
    vehicle.run("摩托车")
    vehicle.run("飞机")
    vehicle.run("汽车")
    // 方案二
    let roadVehicle = new RoadVehicle()
    roadVehicle.run("汽车")
    roadVehicle.run("摩托车")
    let airVehicle = new AirVehicle()
    airVehicle.run("飞机")
    // 方案3
    let vehicle3 = new Vehicle3()
    vehicle3.run('汽车')
    vehicle3.runAir('飞机')
    vehicle3.runWater('轮船')
  }
}
