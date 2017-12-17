export class Member {
  public name: string;
  public id: number;

  constructor(name: string) {
    this.name = name;
  }

  setId(id: number) {
    this.id = id;
  }
}
