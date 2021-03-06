import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../components/client_component/Model/Client';
import { ServiceService } from '../components/client_component/Service/service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [ServiceService]
})
export class LoginComponent implements OnInit {
  email: String;
  password: String;
  client:Client = new Client;

  constructor(public clientService: ServiceService, private router:Router) {}

  ngOnInit() {
  }

  loginClient() {
    this.clientService.loginCliente(this.email, this.password).subscribe(res => {
      this.client=res;
      localStorage.setItem("idClient",this.client.id+"");
      localStorage.setItem("Email", this.client.email+"");
      localStorage.setItem("Name", this.client.name+"");
      localStorage.setItem("Amount", this.client.amount+"");
      if(this.client.shoppingCarts[0] != null){
        localStorage.setItem("idCart", this.client.shoppingCarts[0].id+"");
      }
      this.router.navigate(["/dashboard"]);
    });
  }

  redirectRegister(){
    this.router.navigate(["/register"]);
  }
}
