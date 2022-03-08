import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-allsale',
  templateUrl: './allsale.component.html',
  styleUrls: ['./allsale.component.css']
})
export class AllsaleComponent implements OnInit {

  src="";

  constructor() { }

  ngOnInit(): void {
  }

  generateAllpurchaseReport(){
    
      
    this.src = "http://localhost:8080/ChainSuperShopManagement/reportView3/AllSale";
    console.log(this.src);

}
}
