import React from 'react';
import {
    MDBCard,
    MDBCardBody,
    MDBCardText,
    MDBCardImage,
    MDBCardTitle,
    MDBListGroup, MDBListGroupItem, MDBCardLink
} from 'mdb-react-ui-kit';
import './LandingCard.css';

export default function LandingCard() {
    return (
        <MDBCard style={{ color:"white"}} id="bg-glass">
            <MDBCardImage position='top' alt='...' src='https://www.temenos.com/wp-content/uploads/2020/06/EIU-landscape.-altjpg.jpg' />
            <MDBCardBody>
                <MDBCardTitle>Bankerr</MDBCardTitle>
                <MDBCardText>
                    Your Personal Banking Partner.
                </MDBCardText>
            </MDBCardBody>
            <MDBListGroup flush>
                <MDBListGroupItem style={{background: "none"}}>Security & Help</MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}>Learn More</MDBListGroupItem>
            </MDBListGroup>
            <MDBCardBody>
                <MDBCardLink href='#'><i className="fas fa-map-marker"/> Find Near You</MDBCardLink>
                <MDBCardLink href='#'><i className="fas fa-calendar-alt"/> Schedule an Appointment</MDBCardLink>
            </MDBCardBody>
        </MDBCard>
    );
}