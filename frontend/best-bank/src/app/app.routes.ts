import { Routes } from '@angular/router';
import { App } from './app';
import { Login } from './components/login/login';
import { HomeComponent } from './components/home-component/home-component';
import { Signup } from './components/signup/signup';
import { InitialPage } from './components/initial-page/initial-page';
import { PixArea } from './components/pix-area/pix-area';
import { NewTransfer } from './components/pix-area/new-transfer/new-transfer';
import { Deposit } from './components/deposit/deposit';
import { SakeComponent } from './components/sake-component/sake-component';
import { AfterServicesArea } from './components/after-services-area/after-services-area';
import { PrivatePixArea } from './components/private-pix-area/private-pix-area';
import { KnownTransfer } from './components/known-transfer/known-transfer';

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
    },
    {
        path:'deposit',
        component:Deposit,
        title:'Deposit'
    },
    {
        path:'sake',
        component: SakeComponent,
        title:'Sake'
    },
    {
        path:'afterservice',
        component:AfterServicesArea,
        title:'Everything ok!'
    },
    {
        path:'privatepix',
        component:PrivatePixArea,
        title:'Pix'
    },
    {
        path:'knowtransfer',
        component: KnownTransfer,
        title:'Pix'
    }
];
