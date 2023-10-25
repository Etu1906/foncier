create table propriete(
    idpropriete serial primary key,
    idcin varchar,
    geom geography(POLYGON, 4326),
    adresse varchar,
    description varchar
);-- Insertion de données de test dans la table "propriete"
INSERT INTO propriete (idcin, geom, adresse, description)
VALUES
    ('CIN001', ST_GeogFromText('POLYGON((0 0, 0 1, 1 1, 1 0, 0 0))'), '123 Rue de la Propriete', 'Belle maison avec jardin'),
    ('CIN002', ST_GeogFromText('POLYGON((2 2, 2 3, 3 3, 3 2, 2 2))'), '456 Avenue du Domaine', 'Appartement lumineux'),
    ('CIN003', ST_GeogFromText('POLYGON((4 4, 4 5, 5 5, 5 4, 4 4))'), '789 Boulevard de la Residence', 'Grande ferme avec terrain'),
    ('CIN004',ST_GeogFromText('POLYGON((-122.358 47.578, -122.348 47.577, -122.348 47.573, -122.358 47.573, -122.358 47.578))'), '1010 Rue Principale', 'Maison de ville élégante');

create or replace view v_propriete as(
    select 
    idpropriete,idcin,ST_Area(geom) as superficie, ST_AsText(geom) as geom, adresse, description
    from propriete
);
-- Exemple : Convertir un polygone géométrique en un polygone géographique
SELECT ST_GeogFromText('POLYGON((-122.358 47.578, -122.348 47.577, -122.348 47.573, -122.358 47.573, -122.358 47.578))') AS geography_polygon;
