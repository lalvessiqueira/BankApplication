import React, {Component} from 'react';
import {MDBCol, MDBContainer, MDBRow} from "mdb-react-ui-kit";
import './Landing.css';
import LandingTopBar from "./LandingTopBar";
import LandingCard from "./LandingCard";
import LoginRegister from "./LoginRegister";
import Footer from "./Footer";
import LandingCardGroup from "./LandingCardGroup";

class Landing extends Component {
    render() {
        return (
            <div class="container">
                <div class="row">
                    <LandingTopBar/>
                </div>
                <div>
                    <section>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <LandingCard/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <LoginRegister/>
                            </div>
                        </div>
                    </section>
                </div>
                <div className="row my-5">
                    <h1 style={{color: "whitesmoke"}}>Financial guidance for every stage of life.</h1>
                    <h4 style={{color: "white"}}>Better Money Habits® is here to help with your decisions along the way.</h4>
                    <LandingCardGroup/>
                </div>
                <div className="row">
                    <Footer/>
                </div>
            </div>
        );
    }
}

export default Landing;
//