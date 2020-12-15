import java.util.ArrayList;

public class Serie {
    private ArrayList<Niveau> niveau_1 = new ArrayList<Niveau>();
    private ArrayList<Niveau> niveau_2 = new ArrayList<Niveau>();
    private ArrayList<Niveau> niveau_3 = new ArrayList<Niveau>();

    //
    public Serie() {
        fillCollection();
    }

    //
    public Niveau getQuestion(int niveau, int position) {
        switch (niveau) {
            case 1:
                return niveau_1.get(position);
            case 2:
                return niveau_2.get(position);
            case 3:
                return niveau_3.get(position);
            default:
                return null;
        }
    }

    public ArrayList<Niveau> getQuestions(int niveau) {
        switch (niveau) {
            case 1:
                return niveau_1;
            case 2:
                return niveau_2;
            case 3:
                return niveau_3;
            default:
                return null;
        }
    }

    //
    private void fillCollection() {
        niveau_1.add(new Niveau("JAVA est un langage", new String[]{"Compilé", "Interprété", "Compilé et interpreté"}, 3));
        niveau_1.add(new Niveau("Toutes les classes héritent de la classe", new String[]{"Main", "Object", "AWT"}, 2));
        niveau_1.add(new Niveau("Par convention une classe", new String[]{"est en minuscule", "commence par une majuscule", "est en majuscules"}, 2));
        niveau_1.add(new Niveau("Est-ce que on peut avoir plusieurs constructeurs pour la même classe", new String[]{"oui", "non"}, 1));
        niveau_1.add(new Niveau("Dans la ligne \"public class A implements B\", B est :", new String[]{"Interface", "Classe parent", "Package"}, 1));
        //
        niveau_2.add(new Niveau("Après la compilation, un programme écrit en JAVA, il se transforme en programme en bytecode Quelle est l’extension du programme en bytecode ?", new String[]{"aucun des choix", ".JAVA", ".Class"}, 3));
        niveau_2.add(new Niveau("Class Test\n" +
                "Public Test () \n" +
                "System.out.println(”Bonjour”);\n" +
                "public Test (int i) \n" +
                "this();\n" +
                "System.out.println(”Nous sommes en ”+i+ ” !”);;\n" +
                "\n" +
                "qu’affichera l’instruction suivante?\n" +
                "Test t1=new Test (2018);\n", new String[]{"aucun des choix", "Bonjour\n" +
                "Nous sommes en 2018 !", "Nous sommes en 2018 !"}, 1));
        niveau_2.add(new Niveau("Voici un constructeur de la classe Employee, y-at'il un problème ?\n" +
                "Public void Employe(String n)Nom=n;", new String[]{"vrai", "faux"}, 2));
        niveau_2.add(new Niveau("Pour spécifier que la variable ne pourra plus être modifiée et doit être initialisée dès sa déclaration, on la déclare comme une constante avec le mot réservé", new String[]{"aucun des choix", "final", "const"}, 2));
        niveau_2.add(new Niveau("Dans une classe, on accède à ses variables grâce au mot clé", new String[]{"aucun des choix", "this", "super"}, 2));
        //
        niveau_3.add(new Niveau("calculerSalaire(int)\n" +
                "calculerSalaire(int, double)\n" +
                "La méthode calculerSalaire est :", new String[]{"aucun des choix", "surchargée", "redéfinie"}, 2));
        niveau_3.add(new Niveau("Une classe qui contient au moins une méthode abstraite doit être déclarée abstraite", new String[]{"vrai", "faux"}, 1));
        niveau_3.add(new Niveau("Est-ce qu’une classe peut implémenter plusieurs interfaces ?", new String[]{"vrai", "faux"}, 1));
        niveau_3.add(new Niveau("La déclaration d'une méthode suivante : public void traitement() throws IOException précise que la méthode propage une exception contrôlée", new String[]{"vrai", "faux"}, 1));
        niveau_3.add(new Niveau("class Test\n" +
                "public static void main (String[] args) \n" +
                "try \n" +
                "int a =10;\n" +
                "System.out.println (\"a = \" + a );\n" +
                "int b = 0 / a;\n" +
                "System.out.println (\"b = \" + b);\n" +
                "\n" +
                "catch(ArithmeticException e)\n" +
                "System.out.println (\"diviser par 0!\"); \n" +
                "finally\n" +
                "System.out.println (\"je suis à l’intérieur de\n" +
                "finally\");)\n", new String[]{"aucun des choix", "a=10\n" +
                "b=0\n" +
                "Je suis à l’intérieur de finally", "a=10\n" +
                "b=0\n" +
                "diviser par 0! \n" +
                "Je suis à l’intérieur de finally"}, 2));


    }
}