import Log from './log/Log';
import SingleResponsibility from './design-mode/single-responsibility/Single-Responsibility';
import Segregation from './design-mode/interface-segregation-principle/Segregation';
import Segregation2 from './design-mode/interface-segregation-principle/Segregation2';
import DependecyInVersion from './design-mode/dependence-Inversion-Principle/DependecyInversion';
import DependecyInVersion2 from './design-mode/dependence-Inversion-Principle/DependecyInversion2';
import DependecyInVersion3 from './design-mode/dependence-Inversion-Principle/DependecyInversion3';
import Liskov from './design-mode/liskov/Liskov';
import Liskov2 from './design-mode/liskov/Liskov2';
import OCP from './design-mode/ocp/OCP';
import OCP2 from './design-mode/ocp/OCP2';
import QuickSort from './sort/QuickSort';
import BabbleSort from './sort/BabbleSort';
import SelectSort from './sort/SelectSort';
import InsertSort from './sort/InsertSort';
import ShellSort from './sort/ShellSort';
import ShellSort2 from './sort/ShellSort2';
import MergeSort from './sort/MergeSort';
import RadixSort from './sort/RadixSort';
import HeapSort from './sort/HeapSort';
import CountSort from './sort/CountSort';
import HeapSortArray from './sort/HeapSortArray';
import HTMLLog from './log/Log';
import Demeter from './design-mode/demeter/Demeter';
import DemeterImprove from './design-mode/demeter/DemeterImprove';
import Person from './design-mode/SingletonPattern/Test';
// import Person from './design-mode/SingletonPattern/js/Test';
const log = new HTMLLog()
function add(a: number, b: number): number {
  return a + b
}
let sum = add(3, 2)
log.show(sum, '测试number类型')
function userInfo(name: string): string;
function userInfo(age: number): number;
function userInfo(info: any): any {
  if (typeof info === 'string') {
    return `my name is ${info}`
  } else {
    return `my age is ${info}`
  }
}
log.show(userInfo('wmw'), '函数重载')
log.show(userInfo(18)) //  my age is 18

// SingleResponsibility.main()
// Segregation.main()
// Segregation2.main()
// DependecyInVersion.main()
// DependecyInVersion2.main()
// DependecyInVersion3.main()
// Liskov.main()
// Liskov2.main()
// OCP.main()
// OCP2.main()
// console.time('QuickSort')
// new QuickSort().main()
// console.timeEnd('QuickSort')

// console.time('heapSortArray')
// new HeapSortArray().main()
// console.timeEnd('heapSortArray')

// console.time('shellSort')
// new ShellSort().main()
// console.timeEnd('shellSort')
// console.time('shellSort2')
// new ShellSort2().main()
// console.timeEnd('shellSort2')
// console.time('BabbleSort')
// new BabbleSort().main()
// console.timeEnd('BabbleSort')
// console.time('selectSort')
// new SelectSort().main()
// console.timeEnd('selectSort')
// console.time('insertSort')
// new InsertSort().main()
// console.timeEnd('insertSort')

// console.time('HeapSort')
// new HeapSort().main()
// console.timeLog('HeapSort')
// console.time('radixSort')
// new RadixSort().main()
// console.timeEnd('radixSort')

// console.time('mergeSort')
// new MergeSort().main()
// console.timeEnd('mergeSort')
// console.time('countSort')
// new CountSort().main()
// console.timeEnd('countSort')
// console.log(process.env.NODE_ENV)

// mlog.log('hh')
// mlog.info('console.log')
// Demeter.main()
// DemeterImprove.main()
// console.log(new Person() === new Person()) // false
// console.log(Person.getPerson() === Person.getPerson()) // true 
// Person.getPerson().sayHello()  // Hello World xxx
