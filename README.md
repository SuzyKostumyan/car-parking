# Parking Management System

## Overview
The Parking Management System is designed to facilitate efficient management of car parking spaces within private communities such as residential buildings. It provides a centralized platform for residents to reserve, occupy, and release parking spots.

## Features
- **Booking a Parking Spot**: Users can view available parking spots and reserve spots for specific times and durations.
- **Parking the Car**: Upon arrival at the reserved spot, residents can update the spot's status to 'occupied' via the app.
- **Releasing the Spot**: Users can mark a parking spot as free when they leave.
- **Community Management**: Each parking spot is associated with a private community.


## Community API Endpoints
- Create Community (POST /communities): Creates a new community from the provided request body.
- Get Community by ID (GET /communities/{id}): Retrieves detailed information about a specific community based on its ID.
- Get All Communities (GET /communities): Lists all available communities.

## Parking Spot API Endpoints
- Create Parking Spot (POST /parking-spots): Registers a new parking spot linked to a specified community.
- Get Available Spots (GET /parking-spots/available): Fetches a list of available parking spots, optionally filtered by community ID.
- Reserve Parking Spot (POST /parking-spots/{id}/reserve): Reserves a specific parking spot based on a reservation request.
- Park Car (PATCH /parking-spots/{id}/park): Updates the status of a parking spot to "occupied" when a car parks in the designated spot.
- Book on the Spot (POST /parking-spots/book-on-the-spot): Allows for immediate booking and occupation of a parking spot without prior reservation.
- Release Parking Spot (PATCH /parking-spots/{id}/release): Releases a previously occupied parking spot, making it available for new bookings.
