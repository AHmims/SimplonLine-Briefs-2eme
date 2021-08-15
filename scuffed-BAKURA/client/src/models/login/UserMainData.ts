import Role from '@/models/login/Role';

export default interface UserMainData {
  id: string;
  nom: string;
  email: string;
  avatar: string;
  role: Role;
  typeUtilisateur: string;
  status: number;
  creationDate: Date;
}
