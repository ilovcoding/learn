class Person{
  public sayHello(){
    console.log('Hello World TypeScript')
  }
  private static say:Person = new Person()
  public static getPerson():Person{
    return this.say
  } 
}

export default Person