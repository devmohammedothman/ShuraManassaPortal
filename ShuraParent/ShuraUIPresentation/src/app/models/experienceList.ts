import { Experience } from "./experience";

export class ExperienceList {
    private uniqueExperiences: Experience[] = [];

    get length() {
        return this.uniqueExperiences.length;
    }

    addList(expList:Experience[])
    {
        for(var i = 0 ; i < expList.length ; i++)
        {
            this.add(expList[i]);
        }
    }

    add(expObj: Experience) {
        if (this.exists(expObj)) {
            // throw 'Duplicate point';
            return false;
        }

        this.uniqueExperiences.push(expObj);
        return true;
    }

    exists(expObj: Experience) {
        return this.findIndex(expObj) > -1;
    }

    findIndex(expObj: Experience) {
        for (var i = 0; i < this.uniqueExperiences.length; i++) {
            var existingExp = this.uniqueExperiences[i];
            if (existingExp.id === expObj.id) {
                return i;
            }
        }

        return -1;
    }

    getUniqueExperienceList():Experience[]
    {
        if(this.uniqueExperiences != null && this.uniqueExperiences.length > 0)
            return this.uniqueExperiences;
        else 
             return null;
    }
}