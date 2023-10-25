create table citoyen(
    idcin varchar primary key,
    nom varchar, 
    prenom varchar, 
    adresse varchar ,
    dateNaissance varchar 
);

create table allergie(
    idAllergie serial primary key, 
    allergie varchar
);
create table citoyen_allergie(
    idcin varchar references citoyen(idcin), 
    idAllergie integer references allergie(idAllergie)
);
create table partie_corps(
    idPartieCorps serial primary key, 
    nomPartieCorps varchar
); 
create table operation(
    idOperation serial primary key, 
    idPartieCorps integer references partie_corps(idPartieCorps), 
    dateOperation date, 
    idcin varchar references citoyen(idcin)
);
create table maladie(
    idMaladie serial primary key, 
    nomMaladie varchar
);
create table citoyen_maladie(
    idcin varchar references citoyen(idcin), 
    idMaladie integer references maladie(idMaladie)
);
create table devise(
    iddevise serial primary key, 
    nomDevise varchar
);
create table cours(
    idcours serial primary key, 
    idDevise integer references devise(iddevise), 
    tauxAchat numeric, 
    tauxVente numeric,
    dateCours date 
);

select 
iddevise, dateCours, taux
from cours  
where dateCours = (select max(dateCours) from cours where iddevise = 1 and dateCours <= '2023-10-15') and iddevise = 1
