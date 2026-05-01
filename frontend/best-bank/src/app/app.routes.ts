import { Routes } from '@angular/router';
import { App } from './app';
import { Login } from './components/login/login';
import { HomeComponent } from './components/home-component/home-component';
import { Signup } from './components/signup/signup';
import { InitialPage } from './components/initial-page/initial-page';
import { PixArea } from './components/pix-area/pix-area';
import { NewTransfer } from './components/pix-area/new-transfer/new-transfer';

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
        title:'Signup'
    },
    {
        path:'initial',
        component: InitialPage,
        title:'InitialPage'
    },
    {
        path:'pixarea',
        component: PixArea,
        title:'Pix Area'
    },
    {
        path:'newTransfer',
        component:NewTransfer,
        title:'New Transfer'
    }
];
