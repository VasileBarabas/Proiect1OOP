import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isStudentOrTeacher = true;
        boolean isInteracting = true;
        CatalogClass catalogClass = new CatalogClass();
        catalogClass.set_numberOfStudent(0);
        System.out.println("Introduceti una dintre optiuni: ");
        System.out.println("1.Sunt profesor");
        System.out.println("2.Sunt elev");
        int optiune1 = sc.nextInt();
        while (isStudentOrTeacher) {
            switch (optiune1) {
                case 1:
                    System.out.println("Introduceti una dintre optiuni: ");
                    System.out.println("1.Introducere elev");
                    System.out.println("2.Adaugare note elev");
                    System.out.println("3. Iesire");
                    int optiune2 = sc.nextInt();
                    switch (optiune2) {
                        case 1:
                            //setare date generale elev
                            System.out.println("Ati ales sa introduceti un elev");
                            String fullName, specs, CNP, password, numberOfClasses;
                            System.out.print("Numele complet al  elevului:");
                            fullName = sc.next();
                            System.out.print("Specializarea  elevului:");
                            specs = sc.next();
                            System.out.print("CNP-ul  elevului:");
                            CNP = sc.next();
                            System.out.print("Parola elevului de accesare carnet:");
                            password = sc.next();
                            StudentClass student = new StudentClass(fullName, specs, CNP, password);
                            while (student.get_CNP() == "0") {
                                System.out.println("Cnp incorect, reincercati");
                                CNP = sc.next();
                                student.set_CNP(CNP);
                            }
                            //setare carnet
                            String className;
                            System.out.println(student.toString());
                            System.out.print("Numarul de clase pe care il are elevul");
                            numberOfClasses = sc.next();
                            while (!student.isNumber(numberOfClasses)) {
                                System.out.println("Numar de clase invalid, reincercati");
                                numberOfClasses = sc.next();
                            }
                            int numClasses = Integer.parseInt(numberOfClasses);
                            String nameOfClasses[] = new String[numClasses];
                            int numberOfGrades[] = new int[numClasses];
                            int classGrades[][] = new int[numClasses][10];
                            for (int i = 0; i < numClasses; ++i) {
                                System.out.print("Numele materiei " + i + ":");
                                className = sc.next();
                                nameOfClasses[i] = className;
                                System.out.print("Numarul de note la aceasta materie e:");
                                numberOfGrades[i] = sc.nextInt();
                            }
                            GradebookClass gradebookClass = new GradebookClass(fullName, specs, CNP, password, numClasses, nameOfClasses, numberOfGrades);
                            System.out.println(gradebookClass.toString());
                            //introducere elev in catalog
                            catalogClass.set_gradebooksClass(gradebookClass, catalogClass.get_numberOfStudent());
                            catalogClass.set_numberOfStudent(catalogClass.get_numberOfStudent() + 1);
                            System.out.println(catalogClass.toString());
                            break;
                        //Adaugare note
                        case 2:
                            String searchedCNP;
                            int classChosen, numberOfGrades1;
                            System.out.print("Elevul cautat dupa CNP este:");
                            searchedCNP = sc.next();
                            GradebookClass gradebookClassSearched = catalogClass.studentSearch(searchedCNP);
                            if (gradebookClassSearched != null) {
                                System.out.println("Am gasit elevul");
                                System.out.println("Alegeti materia la care doriti sa introduceti nota");
                                gradebookClassSearched.afisareMaterii();
                                classChosen = sc.nextInt();
                                System.out.println("Numarul de note pe care doriti sa il introduceti");
                                numberOfGrades1 = sc.nextInt();
                                if (numberOfGrades1 > gradebookClassSearched.numberOfGrades(classChosen)) {
                                    System.out.println("Numarul de note pe care vreti sa il introduceti e mai mare decat numarul de note setat");
                                } else {
                                    int[][] newGrades = gradebookClassSearched.get_classGrades();
                                    for (int i = 0; i < numberOfGrades1; ++i) {
                                        System.out.println("Nota");
                                        newGrades[classChosen][i] = sc.nextInt();
                                    }
                                    gradebookClassSearched.set_classGrades(newGrades);

                                }
                            } else {
                                System.out.println("Nu am gasit elevul");
                            }

                            break;
                        case 3:
                            isStudentOrTeacher=false;
                            break;
                        default:
                            isStudentOrTeacher=false;
                            break;
                    }
            }
        }
    }
}
