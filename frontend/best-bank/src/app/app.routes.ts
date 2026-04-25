import { Routes } from '@angular/router';
import { App } from './app';
import { Login } from './components/login/login';
import { HomeComponent } from './components/home-component/home-component';
import { Signup } from './components/signup/signup';

export const routes: Routes = [
    {
        path:'',
        component:HomeComponent,
        title:'Home'
    },
    {
        path:'login',
        component:Login,
        title:'Login'
    },
    {
        path:'signup',
        component:Signup,
        title:"Signup"
    }
];
