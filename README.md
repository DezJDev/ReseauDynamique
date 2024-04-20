# ReseauDynamique
Interface Homme/Machine illustrant la création d'un réseau. 
Ajoutez des ordinateurs connectés à des commutateurs. 
Réalisez les liens entre les ordinateurs et les commutateurs. 
Composez les tables de routage du réseau. 
Ce projet utilise l'algorithme de Dijkstra modifié. Projet réalisé avec Adrien DELMASTRO 

## 1- Rappel et Analyse du sujet:
 ### 1.1- Rappel du sujet:
      Il nous est demandé de réaliser un logiciel permettant de créer une topologie de réseau.
    Cela doit être fait depuis une classe java ou depuis un fichier ou graphiquement. On doit
    pouvoir définir le chemin le plus court entre deux appareils et restituer le chemin
    graphiquement. On doit aussi pouvoir établir la table de routage d’un commutateur.

 ### 1.2- Analyse du sujet:
        Afin de réaliser le TP, on a réfléchi à la forme de la structure de donnée permettant de 
      représenter un réseau. Elle doit forcément permettre de se déplacer d’entité en entité en son
      sein à l’image d’une liste chaînée ou d’un arbre.
      On a constaté que le résultat serait similaire à un graphe.

## 2- Choix techniques:
  ### 2.1- L’interface Homme Machine:
      L’interface est réalisée avec Swing. La représentation est réalisée à l’aide de la 
    bibliothèque graphStream. Commutateurs en noir et ordinateurs en rouge.

![Capture d'écran 2024-04-20 085332](https://github.com/DezJDev/ReseauDynamique/assets/144434644/1b8c2c30-d4e4-4589-a167-35217532152f)

  ### 2.2- Création du réseau:
      L’interface qu’on à réalisée, à pour but de restreindre les actions de l'utilisateur afin qu’il 
    puisse réaliser des actions conformes à la création d’un réseau.
    Il est impossible de:
    ● Connecter un appareil avec lui même.
    ● Connecter deux appareils qui le sont déjà.
    ● Connecter un ordinateur deux fois.
    ● Créer une connexion ayant un poids null ou ne correspondant pas à une valeur numérique.
      Le nom des appareils est défini par l’application. Le nom d’un appareil est une lettre de 
    l’alphabet. Une fois la lettre Z atteinte, on ne peut plus rajouter d’appareil.
    A chaque ajout d’un appareil, un item est ajouté au combox qui sont vides au lancement de 
    l’application. L’attribut graph est aussi mit à jour afin d’afficher l’ajout.

  ### 2.3- Interaction avec le réseau:
    Une fois que le réseau est connexe, il est possible de:
    - Trouver le chemin le plus court entre deux appareils. Cela est réalisé à l’aide de l’algorithme
    de Dijkstra. Nous avons choisi d’utiliser cet algorithme car nous avons fait un oral dessus 
    en anglais et que nous l’avons déjà implémenté dans un projet personnel.
    - Définir et afficher la table de routage d’un commutateur. Cette option n’est pas rendue 
    possible pour l’interface, car la combobox permettant de choisir le commutateur n'inclut pas 
    les ordinateurs. Pour réaliser la table de routage on a encore une fois utilisé l’algorithme de 
    Dijkstra qu’on modifié afin qu’il ne passe pas par le commutateur dont on créer la table.
    Cela implique qu’on ne peut pas réaliser la table de routage d’un commutateur qui est un 
    nœud de transition obligatoire. Ce cas n’est pas géré par l’application.
    Pour s’assurer que le réseau est connexe on le parcourt à l’aide d’une Depth search. Au 
    cours de celle-ci on place dans une arraylist les éléments parcourus et on retourne la taille 
    de celle-ci. Si la taille ne correspond pas au nombre d’appareils connectés au réseau alors 
    le réseau n’est pas connexe.

  ### 2.4- Le réseau et ses entité:
    2.4.1- Le réseau:

![Capture d'écran 2024-04-20 085450](https://github.com/DezJDev/ReseauDynamique/assets/144434644/22c4b236-2a1a-4d58-8321-40788ee074b0)

      - L’ArrayList appareils contient les appareils(commutateur ou ordinateur) du réseau.
      - L’ArrayList commutateurs contient les commutateurs du réseau. Elle sert pour l’algorithme
      de Dijkstra.
      - L’ArrayList arteres contient toutes les artères du réseau.
      - L’entier nbElem correspond au nombre d’appareils du réseau.
      - Le graph permet de représenter graphiquement le réseau
      - Alphabet correspond à toutes les lettres de l’alphabet pour pouvoir nommer les appareils du
      réseau.
      - NB_MAX_APPAREIL est une constante correspondant au nombre d’appareils maximum du
      réseau.

    2.4.2- Les appareils:

![Capture d'écran 2024-04-20 085558](https://github.com/DezJDev/ReseauDynamique/assets/144434644/bfaf30db-4570-48e3-9463-ee053c23e675)
      
      La classe Appareil est abstraite. Les attributs distance et precedent permettent d'utiliser 
      l’algorithme de Dijkstra.
      Pour se déplacer sur un réseau, il suffit de choisir une artère dans l’arraylist tabArtere d’un 
      appareil et de devenir l’appareil de l’autre côté de l'artère.
      Un commutateur est représenté de cette manière: 

 ![Capture d'écran 2024-04-20 085646](https://github.com/DezJDev/ReseauDynamique/assets/144434644/6b487746-8cd3-4356-b1e3-098839a2b234)
      Un ordinateur est représenté de cette manière: 

  ![Capture d'écran 2024-04-20 085709](https://github.com/DezJDev/ReseauDynamique/assets/144434644/29623db0-dd17-45f0-9513-43c4f8d8c085)
      

      2.4.3- Les artères:

  ![Capture d'écran 2024-04-20 085752](https://github.com/DezJDev/ReseauDynamique/assets/144434644/9d05b029-bcc3-4d77-b325-4c294c5b59c4)
      
      Elles permettent de relier des appareils entre eux. Leur id est égale à l’id de l’appareil A collé
      à l’idée de l’appareil B.
      Exemple: Une artère reliant le commutateur A et le commutateur B a comme id AB.

   ![Capture d'écran 2024-04-20 085949](https://github.com/DezJDev/ReseauDynamique/assets/144434644/a2217ff5-1e71-4acd-bccb-ece92ecfa454)

  ### 2.5- Une route:

![Capture d'écran 2024-04-20 090038](https://github.com/DezJDev/ReseauDynamique/assets/144434644/71111bff-7472-49dc-a5ba-245641194af2)

    Une route est un ensemble d’appareils ordonnés et un poids.

  ### 2.6- Chemin le plus court et table de routage:

      Pour réaliser un recherche du plus court chemin ou une table de routage, on a décidé de 
      créer des classes dédiées à cela. Une instance de ces classes est créée à chaque fois.

    2.6.1- Chemin le plus court:

![Capture d'écran 2024-04-20 090124](https://github.com/DezJDev/ReseauDynamique/assets/144434644/c45529b0-bdb1-4e4a-b4ea-5d4741c9867d)
![Capture d'écran 2024-04-20 090159](https://github.com/DezJDev/ReseauDynamique/assets/144434644/0c9354d7-bd16-4eee-949c-5d79f9088743)
      
      Le constructeur permet de récupérer le réseau sur lequel on veut réaliser une 
      opération. Il définit l’appareil correspondant au point de départ de la recherche.
      L’arrayList nonVisite contient tous les appareils du réseau. La recherche s'arrête quand tous
      les appareils ont été visités.
      La méthode preparerGraph() met tous les attributs distance des appareils à 
      Integer.MAX_VALUE et les attributs précédent à null.

![Capture d'écran 2024-04-20 090821](https://github.com/DezJDev/ReseauDynamique/assets/144434644/77f81f0b-f570-477e-b907-57f038915678)

![Capture d'écran 2024-04-20 090848](https://github.com/DezJDev/ReseauDynamique/assets/144434644/ec63c42f-30c2-4e24-84a7-454d78bc6aa2)

    Tous les voisins de l’appareil courant sont consultés. Si leur attribut distance est plus
    grand que la distance de l’appareil courant ajouté au poids de l’artère qu’ils ont en 
    commun alors la distance est mise à jour et l’attribut précédent devient l’appareil 
    courant. Une fois cela fait, on se déplace sur le commutateur ayant la plus petite 
    distance de l’arrayList nonVisite.
    De cette façon, on pourra suivre le chemin le plus court pour chaque appareil à partir
    de celui ou la recherche a été lancée.

![Capture d'écran 2024-04-20 090919](https://github.com/DezJDev/ReseauDynamique/assets/144434644/5c529f72-1180-4e45-918b-8978a39145ac)

Dans ce réseau le chemin le plus court entre A et F est:

![Capture d'écran 2024-04-20 090940](https://github.com/DezJDev/ReseauDynamique/assets/144434644/3288c87f-9849-4cc3-93c6-ddf3401389ef)

### 2.6.2- Table de routage:

![Capture d'écran 2024-04-20 091142](https://github.com/DezJDev/ReseauDynamique/assets/144434644/c9d429f1-6bd1-4e00-9b97-ddb015c30f05)

  Cette classe est similaire à la classe précédente, mais l’algorithme de Dijkstra à été modifié 
  afin de ne pas passer par le commutateur dont on fait la table de routage.
  Quand on fait la table de routage du commutateur A, on met la distance du commutateur à 0
  et on le place dans l’arrayList des commutateurs visités. L’algorithme de dijkstra est alors 
  exécuté sur chaque voisin du commutateur A pour chaque commutateur du réseau.
  L’algorithme retourne alors une route à laquelle on ajoute A et le poids de l'artère entre A et 
  chaque voisin.
  Chaque route est placée dans une arrayList pour chaque commutateur. Ces arrayList sont 
  triées en fonction de leur poids.
  A la fin on a donc une ArrayList contenant des ArrayList triées contenant des routes. Il y une
  route par voisin de A pour chaque commutateur du réseau. Le premier commutateur de 
  chaque route est un voisin de A. En récupérant ceux de chaque route on a l’ordre dans 
  lequel les voisins sont par rapport à chaque commutateur du réseau.

![Capture d'écran 2024-04-20 091214](https://github.com/DezJDev/ReseauDynamique/assets/144434644/08babcb0-3bbc-44f3-8baa-fbb0155209c1)

## 3- Conclusion:

![Capture d'écran 2024-04-20 091247](https://github.com/DezJDev/ReseauDynamique/assets/144434644/d3dc74e5-79eb-49ac-8708-0419f26f155d)

  A l’aise avec les algorithmes liés au graph, nous n’avons pas rencontré de difficultés.
  Nous avons apporté une attention à l’interface homme machine et avons restreint les
  actions que peuvent effectuer les utilisateurs. Cependant le cas ou un commutateur 
  est un point de passage obligatoire n’est pas géré et cela créer une erreure quand 
  on essaie d’en faire la table de routage.
  Il pourrait être intéressant de rajouter un réseau par défaut pour tester le programme
  dans les mêmes conditions lors de l’ajout d’une fonctionnalité. Il faudrait aussi 
  pouvoir ajouter plus de 26 appareils. Il suffirait de rajouter une lettre au nom des 
  appareils. Cela n’a pas été fait car les lettres dépasseraient des cercles et nous 
  avons jugé que 26 appareils seraient suffisant pour dans notre contexte.
  Il aurait été pratique de pouvoir créer un réseau depuis une classe java ou un fichier.
  Cela n’a pas été effectué car on a manqué de temps.
  Merci pour votre attention.
