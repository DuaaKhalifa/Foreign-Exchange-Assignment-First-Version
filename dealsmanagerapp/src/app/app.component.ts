
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Deal } from './deal';
import { DealService } from './deal.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'dealsmanagerapp';
  public deals: Deal[] = [];
  public deal!: Deal|null;
  public deletedDeal!: Deal|null;
  constructor(private dealsService:DealService){}
  ngOnInit(): void {
   this.getDeals();
  }

  public getDeals():void{
    this.dealsService.getDeals().subscribe(
      (response:Deal[])=>{
        this.deals = response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }

  public searchDeals(id:string):void{
    const result: Deal[] = [];
    for(const deal of this.deals){
      if(deal.id.toString() == id){
        result.push(deal);
      }
    }
    this.deals = result;
    if(result.length ===0 || !id){
      this.getDeals();
    }
  }

  public onOpenModal(deal:Deal|null,mode:string):void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    if(mode==='add'){
        button.setAttribute('data-target','#addDealModal');
    }
    if(mode==='edit'){
      this.deal =deal;
      button.setAttribute('data-target','#updateDealModal');
  }
  if(mode==='delete'){
    this.deletedDeal=deal;
    button.setAttribute('data-target','#deleteDealModal');
  }
  container?.append(button);
  button.click();
}

public onAddDeal(addForm: NgForm): void {
  document.getElementById('add-deal-form')?.click();
  this.deal = addForm.value as Deal;
  this.deal.timestamp = new Date
  this.dealsService.addDeal(this.deal).subscribe(
    (response: Deal) => {
      console.log(response);
      this.getDeals();
      addForm.reset();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
      addForm.reset();
    }
  );
}

public onDeleteDeal(id:any){
  this.dealsService.deleteDeal(id).subscribe(
    (response: void) => {
      console.log(response);
      this.getDeals();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}

public onUpdateDeal(deal: Deal): void {
  this.dealsService.updateDeal(deal).subscribe(
    (response: Deal) => {
      console.log(response);
      this.getDeals();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}
}
