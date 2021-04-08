package com.dilitand.marriage;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person person) {
        //Если пол разный и они не супруги то женим
        if (this.man != person.man && (person.spouse == null || this.spouse == null || !this.spouse.equals(person))) {
            //разводим всех
            boolean tmp = false;
            tmp = person.spouse != null ? person.spouse.divorce() : false;
            tmp = spouse != null ? spouse.divorce() : false;
            person.divorce();
            this.divorce();
            //свадьба
            this.spouse = person;
            person.spouse = this;
            System.out.println(person.name + " и " + person.spouse.name + " поженились");
            return true;
        } else {
            System.out.println(this.name  + " и " + person.name + " не удалось поженить");
            return false;
        }
    }

    public boolean divorce() {
        if (this.spouse != null) {
            System.out.println(this.name + " разведен (а)" + "с " + spouse.name);
            this.spouse = null;
            return true;
        } else {
            return false;
        }
    }
}
