export class PollResult {
    committeId: number;
    committeNameEn: string;
    committeNameAr: string;
    wish1Count: number;
    wish2Count: number;
    wish3Count: number;
    sum: number;
    constructor(committeId: number, committeNameEn: string, committeNameAr: string,
        wish1Count: number, wish2Count: number, wish3Count: number,
        sum: number) {
            this.committeId = committeId;
            this.committeNameEn = committeNameEn;
            this.committeNameAr = committeNameAr;
            this.wish1Count = wish1Count;
            this.wish2Count = wish2Count;
            this.wish3Count = wish3Count;
            this.sum = sum;
        }

        get getCommitteId(): number {
            return this.committeId;
        }
    
        set setCommitteId(committeId: number) {
            this.committeId = committeId;
        }

        get getCommitteNameEn(): string {
            return this.committeNameEn;
        }
    
        set setCommitteNameEn(committeNameEn: string) {
            this.committeNameEn = committeNameEn;
        }

        get getCommitteNameAr(): string {
            return this.committeNameAr;
        }
    
        set setCommitteNameAr(committeNameAr: string) {
            this.committeNameAr = committeNameAr;
        }

        get getWish1Count(): number {
            return this.wish1Count;
        }
    
        set setWish1Count(wish1Count: number) {
            this.wish1Count = wish1Count;
        }

        get getWish2Count(): number {
            return this.wish2Count;
        }
    
        set setWish2Count(wish2Count: number) {
            this.wish2Count = wish2Count;
        }

        get getWish3Count(): number {
            return this.wish3Count;
        }
    
        set setWish3Count(wish3Count: number) {
            this.wish3Count = wish3Count;
        }

        get getSum(): number {
            return this.sum;
        }
    
        set setSum(sum: number) {
            this.sum = sum;
        }

}