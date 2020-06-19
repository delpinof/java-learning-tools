package com.fherdelpino.anonymousClasses;

public class HelloWorldAnonymousClasses {
	int outterCount;
	interface HelloWorld {
		public void greet();
		public void greetSomeone(String someone);
	}

	public void sayHello() {

		int innerCount;

		class EnglishGreeting implements HelloWorld {
			String name = "world";
			@Override
			public void greet() {
				greetSomeone("world");
			}
			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hello ".concat(name));
				outterCount++;
				//innerCount++; member not accesible if it's not final
			}
		}//end class EnglishGreeting

		HelloWorld englishGreeting = new EnglishGreeting();

		HelloWorld frenchGreeting = new HelloWorld() {
			String name = "tout le monde";
			@Override
			public void greet() {
				greetSomeone("tout le monde");

			}
			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Salut ".concat(name));
				outterCount++;
//				innerCount++;
			}
		}; //end FrenchGreeting class

		HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        }; // end SpanishGreeting class

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();

	}//end sayHello() method

	public static void main(String... args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}
