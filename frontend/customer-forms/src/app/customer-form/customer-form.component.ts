import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer'
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  // constructor() { }
  constructor(private http: HttpClient) { }

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
    const data = {'id': this.model.id, "name": this.model.name, "creditLimit": this.model.creditLimit, "company": this.model.company};
    console.log(data);
    const config = { headers: new HttpHeaders().set('Content-Type', 'application/json') };
    this.http.post<Customer>('http://localhost:8081/customer/add', this.model, config).subscribe(myres => {
      // this.postId = data.id;
      this.model.creditLimit = this.model.creditLimit - Number(myres);
    })
  }

  addCustomer2(cus: Customer) {
    console.log("Send customer");
   
    const config = { headers: new HttpHeaders().set('Content-Type', 'application/json') };
    this.http.post<Customer>('http://localhost:8081/customer/add', cus, config).subscribe(data => {
      // this.postId = data.id;
    })
  }


}
