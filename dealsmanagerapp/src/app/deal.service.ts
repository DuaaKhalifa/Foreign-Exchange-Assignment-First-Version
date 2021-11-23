import { Observable } from "rxjs";

import { HttpClient } from '@angular/common/http';
import { Deal } from "./deal";
import { environment } from "src/environments/environment";
import { Injectable } from "@angular/core";

@Injectable({providedIn:'root'})
export class DealService{
    private apiServerUrl =environment.apBaseUrl;
    constructor(private http:HttpClient){

    }
    public getDeals():Observable<Deal[]>{
        return this.http.get<Deal[]>(`${this.apiServerUrl}/deal/all`);
    }
    public addDeal(deal:Deal):Observable<Deal>{
        return this.http.post<Deal>(`${this.apiServerUrl}/deal/add`,deal);
    }
    public updateDeal(deal:Deal):Observable<Deal>{
        return this.http.put<Deal>(`${this.apiServerUrl}/deal/update`,deal);
    }
    public deleteDeal(dealId:number):Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}/deal/delete/${dealId}`);
    }

}