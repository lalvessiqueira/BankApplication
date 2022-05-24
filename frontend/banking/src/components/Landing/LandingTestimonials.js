import React from 'react';
import {MDBCardBody, MDBCardTitle, MDBCardSubTitle, MDBCardText, MDBCardLink, MDBCard} from 'mdb-react-ui-kit';

export default function LandingTestimonials() {
    return (
        <MDBCard className='my-3' id='bg-glass'>
            <MDBCardBody>
                <MDBCardTitle style={{color: 'black'}}>"Bankerr saved my marriage."</MDBCardTitle>
                <MDBCardText style={{color: 'black'}}>
                    Before Bankerr, I was up to my neck in debt and didn't know how to budget. My wife and kids were leaving me but then I created an account and everything was resolved. Thanks, Bankerr!
                </MDBCardText>
            </MDBCardBody>
        </MDBCard>
    );
}
