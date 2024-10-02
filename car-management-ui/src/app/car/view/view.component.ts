import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CarService } from '../../service/car.service';
import { ReservationService } from '../../service/reservation.service';
import { Car } from '../../model/car';
import { Reservation } from '../../model/reservation';

@Component({
  selector: 'app-view',
  standalone: true,
  imports: [],
  templateUrl: './view.component.html',
  styleUrl: './view.component.css'
})
export class ViewComponent {
  carId: string | null = null;
  car: Car | null = null;
  reservations: Reservation[] | null = null;

  constructor(private route: ActivatedRoute, public carService: CarService, public reservationService: ReservationService) { }

  ngOnInit(): void {
    this.carId = this.route.snapshot.paramMap.get("carId");

    if (this.carId != null) {
      this.carService.getById(this.carId).subscribe(car => {
        this.car = car;
      });

      this.reservationService.getById(this.carId).subscribe(reservations => {
        this.reservations = reservations;
      });
    }
  }
}
