-- Insertion de données dans la table citoyen
INSERT INTO citoyen (idcin, nom, prenom,dateNaissance, adresse)
VALUES
    ('CIN001', 'Doe', 'John' , '2023-08-08', '13 Rue Lenine Ankadifotsy'),
    ('CIN002', 'Smith', 'Jane', '09-08-2023', '19 Rue Lenine Ankadifotsy'),
    ('CIN003', 'Brown', 'Michael',  '08-10-2023', '14 Rue Lenine Ankadifotsy');

-- Insertion de données dans la table allergie
INSERT INTO allergie (allergie)
VALUES
    ('Allergie aux noix'),
    ('Allergie au pollen'),
    ('Allergie au gluten');
-- Insertion de données dans la table citoyen_allergie
INSERT INTO citoyen_allergie (idcin, idAllergie)
VALUES
    ('CIN001', 1),
    ('CIN001', 2),
    ('CIN001', 3),
    ('CIN002', 1),
    ('CIN002', 2),
    ('CIN002', 3),
    ('CIN003', 1),
    ('CIN003', 2),
    ('CIN003', 3);

-- Insertion de données dans la table partie_corps
INSERT INTO partie_corps (nomPartieCorps)
VALUES
    ('Tete'),
    ('Bras'),
    ('Jambe');

-- Insertion de données dans la table operation
INSERT INTO operation (idPartieCorps, dateOperation, idcin)
VALUES
    (1, '2023-09-15', 'CIN001'),
    (2, '2023-08-20', 'CIN002'),
    (3, '2023-09-10', 'CIN003');

-- Insertion de données dans la table maladie
INSERT INTO maladie (nomMaladie)
VALUES
    ('Diabete'),
    ('Asthme'),
    ('Hypertension');

-- Insertion de données dans la table citoyen_maladie
INSERT INTO citoyen_maladie (idcin, idMaladie)
VALUES
    ('CIN001', 1),
    ('CIN002', 2),
    ('CIN003', 3);

-- Insérer des données de devise
INSERT INTO devise (nomDevise) VALUES ('Euro');
INSERT INTO devise (nomDevise) VALUES ('USD');
INSERT INTO devise (nomDevise) VALUES ('Yen');
INSERT INTO devise (nomDevise) VALUES ('Ariary');
-- Taux pour une semaine (7 jours)
INSERT INTO cours (idDevise, tauxAchat,tauxVente, dateCours) VALUES
    (1, 4750.56,4500, CURRENT_DATE - INTERVAL '7 days'),  -- Il y a une semaine
    (1, 4750.67,4500, CURRENT_DATE - INTERVAL '6 days'),  -- Il y a 6 jours
    (1, 4750.78,4500, CURRENT_DATE - INTERVAL '5 days'),  -- Il y a 5 jours
    (1, 4750.89,4500, CURRENT_DATE - INTERVAL '4 days'),  -- Il y a 4 jours
    (1, 4750.90,4500, CURRENT_DATE - INTERVAL '3 days'),  -- Il y a 3 jours
    (1, 4750.91,4500, CURRENT_DATE - INTERVAL '2 days'),  -- Il y a 2 jours
    (1, 4750.12,4500, CURRENT_DATE - INTERVAL '1 day');   -- Hier
INSERT INTO cours (idDevise, tauxAchat,tauxVente, dateCours) VALUES (2,4000,3500,CURRENT_DATE);
INSERT INTO cours (idDevise, tauxAchat,tauxVente, dateCours) VALUES (4,1,1,CURRENT_DATE);
    -- Taux pour une semaine (7 jours)
INSERT INTO cours (idDevise, tauxAchat,tauxVente, dateCours) VALUES
    (2, 4510.56,4000, CURRENT_DATE - INTERVAL '7 days'),  -- Il y a une semaine
    (2, 4510.67,4000, CURRENT_DATE - INTERVAL '6 days'),  -- Il y a 6 jours
    (2, 4510.78,4000, CURRENT_DATE - INTERVAL '5 days'),  -- Il y a 5 jours
    (2, 4510.89,4000, CURRENT_DATE - INTERVAL '4 days'),  -- Il y a 4 jours
    (2, 4510.90,4000, CURRENT_DATE - INTERVAL '3 days'),  -- Il y a 3 jours
    (2, 4510.91,4000, CURRENT_DATE - INTERVAL '2 days'),  -- Il y a 2 jours
    (2, 4510.12,4000, CURRENT_DATE - INTERVAL '1 day');   -- Hier

-- Taux pour une semaine (7 jours)
INSERT INTO cours (idDevise, tauxAchat,tauxVente ,dateCours) VALUES
    (3, 154.56,130, CURRENT_DATE - INTERVAL '7 days'),  -- Il y a une semaine
    (3, 154.67,130, CURRENT_DATE - INTERVAL '6 days'),  -- Il y a 6 jours
    (3, 154.78,130, CURRENT_DATE - INTERVAL '5 days'),  -- Il y a 5 jours
    (3, 154.89,130, CURRENT_DATE - INTERVAL '4 days'),  -- Il y a 4 jours
    (3, 154.90,130, CURRENT_DATE - INTERVAL '3 days'),  -- Il y a 3 jours
    (3, 154.91,130, CURRENT_DATE - INTERVAL '2 days'),  -- Il y a 2 jours
    (3, 154.12,130, CURRENT_DATE - INTERVAL '1 day');   -- Hier


------alea
INSERT INTO cours (idDevise, tauxAchat,tauxVente, dateCours) VALUES (2,4930,4450,CURRENT_DATE);
INSERT INTO cours (idDevise, tauxAchat,tauxVente, dateCours) VALUES (1,5150,4890,CURRENT_DATE);