import React from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText, MDBCardFooter, MDBRow, MDBCol } from 'mdb-react-ui-kit';

export default function LandingCardGroup() {
    return (
        <div>
            <h1 style={{color: "whitesmoke"}}>Financial guidance for every stage of life.</h1>
            <h4 style={{color: "white"}}>Better Money Habits® is here to help with your decisions along the way.</h4>
        <MDBRow className='row-cols-1 row-cols-md-3 mt-4 mx-0'>
            <MDBCol>
                <MDBCard background='dark' className='text-white h-100'>
                    <MDBCardImage
                        src='https://images.pexels.com/photos/4386322/pexels-photo-4386322.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'
                        alt='...'
                        position='top'
                    />
                    <MDBCardBody>
                        <MDBCardTitle>Tax Season?</MDBCardTitle>
                        <MDBCardText>
                            Budgeting, Savings, Retirement. All your personal banking needs in the palm of your hand.
                        </MDBCardText>
                    </MDBCardBody>
                    <MDBCardFooter>
                        <small className='text-muted'>Last updated 3 mins ago</small>
                    </MDBCardFooter>
                </MDBCard>
            </MDBCol>
            <MDBCol>
                <MDBCard background='dark' className='text-white h-100'>
                    <MDBCardImage
                        src='https://images.pexels.com/photos/8293738/pexels-photo-8293738.jpeg?cs=srgb&dl=pexels-rodnae-productions-8293738.jpg&fm=jpg'
                        alt='...'
                        position='top'
                    />
                    <MDBCardBody>
                        <MDBCardTitle>Buy/Sell/Rent</MDBCardTitle>
                        <MDBCardText>
                            We get it. The process can be stressful. Allow our trained professionals to handle the boring stuff so you can focus on what matters most.
                        </MDBCardText>
                    </MDBCardBody>
                    <MDBCardFooter>
                        <small className='text-muted'>Last updated 46 mins ago</small>
                    </MDBCardFooter>
                </MDBCard>
            </MDBCol>
            <MDBCol>
                <MDBCard background='dark' className='text-white h-100'>
                    <MDBCardImage
                        src='https://images.pexels.com/photos/6476588/pexels-photo-6476588.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'
                        alt='...'
                        position='top'
                    />
                    <MDBCardBody>
                        <MDBCardTitle>Invest</MDBCardTitle>
                        <MDBCardText>
                            Got a gleam in your eye for that summer home or yacht you've always wanted? It starts with investment and it starts here.
                        </MDBCardText>
                    </MDBCardBody>
                    <MDBCardFooter>
                        <small className='text-muted'>Last updated 1h:36 mins ago</small>
                    </MDBCardFooter>
                </MDBCard>
            </MDBCol>
        </MDBRow>
        </div>
    );
}