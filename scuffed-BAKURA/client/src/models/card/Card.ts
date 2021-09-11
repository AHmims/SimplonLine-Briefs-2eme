import Image from '@/models/image/Image';
import Archetype from '@/models/card/Archetype';
import UserMainData from '@/models/user/UserMainData';
import Attribute from '@/models/card/Attribute';
import Race from '@/models/card/Race';

export default interface Card {
  idCarte: string,
  nomCarte: string,
  descriptionCarte: string,
  givenCarteId: string,
  typeCarte: string,
  imageCarte: Image,
  archetype: Archetype,
  administrateur: UserMainData,
  monsterAtk: number,
  monsterDef: number,
  monsterLvl: number,
  monsterScale: number,
  attribute: Attribute,
  race: Race,
  liked: boolean
}
