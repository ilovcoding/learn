class Person {
    static person = new Person()

    sayHello(){
        console.log('Hello World JavaScript')
    }

    static getPerson(){
        return this.person
    }
}
export default Person

