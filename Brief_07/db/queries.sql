USE sc2nawfal_Brief_07;
-- ---
CREATE TABLE `User`(
	idUser varchar(254) PRIMARY KEY,
    nomUser varchar(254),
    prenomUser varchar(254),
    emailUser varchar(254),
    roleUser varchar(254),
    avatarUser varchar(254)
);
CREATE TABLE `Promo`(
	idPromo varchar(254) PRIMARY KEY,
    titrePromo varchar(254),
    dateDebut datetime,
    dateFin datetime
);
CREATE TABLE `PromoUser`(
	idPromo varchar(254),
	idUser varchar(254)
);
CREATE TABLE `Specialite`(
	idSpecialite varchar(254) PRIMARY KEY,
    titreSpecialite varchar(254)
);
CREATE TABLE `PromoSpecialite`(
	idPromo varchar(254),
	idSpecialite varchar(254)
);
/* DROP TABLE SpecialiteApprenant;
CREATE TABLE `SpecialiteApprenant`(
	idSpecialite varchar(254),
	idUser varchar(254)
); */*
CREATE TABLE `Competence`(
	idCompetence varchar(254) PRIMARY KEY,
    titreCompetence varchar(254)
);
CREATE TABLE `SpecialiteCompetence`(
	idSpecialite varchar(254),
	idCompetence varchar(254)
);
CREATE TABLE `NiveauCompetence`(
	idNiveauCompetence varchar(254) PRIMARY KEY,
    numNiveauCompetence int(11),
    descNiveauCompetence TEXT,
    idCompetence varchar(254)
);
CREATE TABLE `NiveauCompetenceApprenant`(
	idNiveauCompetence varchar(254),
    idUser varchar(254)
);
-- ---
ALTER TABLE `PromoUser`
  ADD CONSTRAINT `fk_PromoUser_user` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`),
  ADD CONSTRAINT `fk_PromoUser_promo` FOREIGN KEY (`idPromo`) REFERENCES `Promo` (`idPromo`);
ALTER TABLE `PromoSpecialite`
  ADD CONSTRAINT `fk_PromoSpecialite_promo` FOREIGN KEY (`idPromo`) REFERENCES `Promo` (`idPromo`),
  ADD CONSTRAINT `fk_PromoSpecialite_specialite` FOREIGN KEY (`idSpecialite`) REFERENCES `Specialite` (`idSpecialite`);
/*
 ALTER TABLE `SpecialiteApprenant`
  ADD CONSTRAINT `fk_SpecialiteApprenant_user` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`),
  ADD CONSTRAINT `fk_SpecialiteApprenant_specialite` FOREIGN KEY (`idSpecialite`) REFERENCES `Specialite` (`idSpecialite`);
*/
ALTER TABLE `SpecialiteCompetence`
  ADD CONSTRAINT `fk_SpecialiteCompetence_competence` FOREIGN KEY (`idCompetence`) REFERENCES `Competence` (`idCompetence`),
  ADD CONSTRAINT `fk_SpecialiteCompetence_specialite` FOREIGN KEY (`idSpecialite`) REFERENCES `Specialite` (`idSpecialite`);
ALTER TABLE `NiveauCompetence`
  ADD CONSTRAINT `fk_NiveauCompetence_specialite` FOREIGN KEY (`idCompetence`) REFERENCES `Competence` (`idCompetence`);
ALTER TABLE `NiveauCompetenceApprenant`
  ADD CONSTRAINT `fk_NiveauCompetenceApprenant_niveauCompetence` FOREIGN KEY (`idNiveauCompetence`) REFERENCES `NiveauCompetence` (`idNiveauCompetence`),
  ADD CONSTRAINT `fk_NiveauCompetenceApprenant_user` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`);
-- ---