package homework.lesson.one.task1;

public class PersonBuilderTest {
    public static void main(String[] args) {
        Person p1 = new PersonBuilder()
                .addFirstName("Sidorov")
                .addLastName("Ivan")
                .addMiddleName("Petrovich")
                .addCountry("Russian Federation")
                .addAddress("Krasnodar, Lenina street, 7 / 25")
                .addPhone("+7 999 888 77 66")
                .addAge(53)
                .addGender("male")
                .build();
        System.out.println(p1);

        Person p2 = new PersonBuilder()
                .addFirstName("Kralova")
                .addLastName("Marketa")
                .addCountry("Czech Republic")
                .addAddress("Prague, Opletalova street, 52 / 87")
                .addPhone("+420 999 111 333")
                .addAge(48)
                .addGender("female")
                .build();
        System.out.println(p2);
    }
}
