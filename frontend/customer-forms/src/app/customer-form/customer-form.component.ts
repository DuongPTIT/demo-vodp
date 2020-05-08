import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer'
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { config } from 'rxjs';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  // constructor() { }
  welcome : string;
  notify : string;
  customers : any
  constructor(private http: HttpClient) { 
    this.welcome = "List customer"
    this.refrestTable();
  }

  ngOnInit(): void {
  }

  companies = ['Viettel', 'VNPT', 'Thai Son'];
  
  model = new Customer(1, 'Pham Van Duong', this.companies[1], 1996);

  submitted = false;

  onSubmit() { this.submitted = true; }
  get diagnostic() { return JSON.stringify(this.model); }

  newHero() {
    this.model = new Customer(12, '', '', 1);
  }

  addCustomer() {
    console.log("chay ham gui");
    const data = {"name": this.model.name, "creditLimit": this.model.creditLimit, "company": this.model.company};
    console.log(data);
    const config = { headers: new HttpHeaders().set('Content-Type', 'application/json') };
    this.http.post<Customer>('http://localhost:8081/customer/create', data, config).subscribe(myres => {
      // this.postId = data.id;
      this.refrestTable();
    })
 
  }



  refrestNot() {
    this.http.get<any>('http://localhost:8081/customer/newestrely').subscribe(response => {
      // this.notify = response;
      this.notify = response.msg;
    })
    console.log("refrest notify");
  }


  refrestTable() {
    this.http.get<any>('http://localhost:8081/customer/').subscribe(data => {
      this.customers = data;
    })
  }


}
