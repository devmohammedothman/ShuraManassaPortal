export class Group {
    description: string;
    nameAr: string;
    nameEn: string;
    active: string;
    
    constructor(description:string, nameAr: string, nameEn: string, active: string) {
        this.description = description;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.active = active;
    }
    
    public static createEmptyGroup():Group{
        return new Group('', '','','');
    }
}