import { Component, Input } from "@angular/core";


@Component({
  selector: 'app-limit',
  imports: [],
  templateUrl: './limit.html',
  styleUrl: './limit.scss',
})
export class Limit {
  @Input() amount: string = "5000,00";
}
