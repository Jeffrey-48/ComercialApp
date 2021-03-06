import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../Model/Product';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  UrlProduct = 'http://ec2-52-91-233-117.compute-1.amazonaws.com:8080/comercialApp/product';

  createProduct(product:Product){
    return this.http.post<Product>(this.UrlProduct + "/addProduct", product);
  }
  listProducts(){
    return this.http.get<Product[]>(this.UrlProduct+"/listProducts");
  }
  updateProduct(product:Product){
    return this.http.put<Product>(this.UrlProduct+"/editProduct",product);
  }
  deleteProduct(id:number){
    return this.http.delete<Product>(this.UrlProduct+"/deleteProduct/" + id);
  }
  listProductsByWord(word:string){
    return this.http.get<Product[]>(this.UrlProduct+"/listProducts/" + word);
  }

}