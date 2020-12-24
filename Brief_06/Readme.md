##Instalation

Windows->preferences->install Javafx

'''Add library JAVAFX JDK

''' Sceane Builder

click_droit->Build_path->Add_libraries->Javafx

'''Doawnload and add javazoomlibrary

##Main 

Appelle de la forme de Login 

## Controller.java

La class qui fait gérer la page de login 

'''StartQuiz() =>  fait vérifier tous les champs et fait appeler a la méthode nextScene();

'''nextScene() => fait une appelle a la view Form 

## Form.java

Initializable() =>  il fait initialisation de la form et aussi lancer le timer qui commance par 5 min il fait aussi la vérification de ce timer et il fait l'appelle aussi a la méthode niveau()
niveau1() => faire initialiser les quiz et appeller a la méthode remplirePanelNiveau(1)
remplirePanelNiveau(1) => il fait remplir la formulaire par les question et les choix de la niveau 1

##  Aprés l'utilisateur clique sur le button valider fait appeller a la méthode actiondb() qui fait appeller al méthode checkréponse 

CheckRéponse()=> la méthode qui fait vérifivier les éponse si fauses lancer une message d'erreur si nom lancer la méthode tentation()



Tentation() = > il vérifier la tentation de l'utilisateur et appeller a la méthode afficherCorrection()

afficherCorrection() = > afficher la correction et par l'appelle de la méthode correction et aussi lancer l'autre niveau 

ValidateForm() => il fait l'appelle de la méthode ActionDB(niv) et donner le niveau qui doit traiter 

##outils utiliser 

* Scene builder
* Java fx JDK
* Eclipse IDE




