import Role from '@/models/user/Role';
import Image from '@/models/image/Image';

export default interface UserMainData {
  id: string;
  nom: string;
  email: string;
  avatar: Image;
  role: Role;
  typeUtilisateur: string;
  status: number;
  creationDate: Date;
  password: string;
}
