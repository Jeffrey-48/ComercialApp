import { Component, OnInit, ElementRef } from '@angular/core';
import { ROUTES } from '../sidebar/sidebar.component';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  word:string = "";
  public focus;
  public listTitles: any[];
  public location: Location;
  public nameClient: String;
  public amountClient: String;

  constructor(location: Location,  private element: ElementRef, private router: Router, private toastr: ToastrService) {
    this.location = location;
  }

  ngOnInit() {
    this.listTitles = ROUTES.filter(listTitle => listTitle);
    this.nameClient = localStorage.getItem("Name");
    this.amountClient = localStorage.getItem("Amount");
  }
  getTitle(){
    var titlee = this.location.prepareExternalUrl(this.location.path());
    if(titlee.charAt(0) === '#'){
        titlee = titlee.slice( 1 );
    }

    for(var item = 0; item < this.listTitles.length; item++){
        if(this.listTitles[item].path === titlee){
            return this.listTitles[item].title;
        }
    }
    return 'Dashboard';
  }

  logout(){
    localStorage.removeItem("idClient")
    localStorage.removeItem("Email")
    localStorage.removeItem("Name")
    localStorage.removeItem("Amount")
    localStorage.removeItem("idCart")
    this.router.navigate(["/dashboard"])
    window.location.reload();
  }

  search(){
    this.router.navigate(["/dashboard"])
    localStorage.setItem("findWord",this.word)
  }

  addAmount(){
    this.toastr.success("Exito", 'Se ha enviado el formulario de recargar dinero a su correo', {
      timeOut: 5000,
    });
  }

}
