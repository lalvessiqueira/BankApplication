import React, {Component} from 'react';
import './Landing.css';
import LandingHeader from "./LandingHeader";
import LandingCard from "./LandingCard";
import LoginRegister from "./LoginRegister";
import Footer from "./Footer";
import LandingCardGroup from "./LandingCardGroup";
import LandingTestimonials from "./LandingTestimonials";
import Profile from "../CustomerDash/Profile";

class Landing extends Component {
    render() {
        return (
            <div className="container">
                <div className="row">
                    <LandingHeader/>
                </div>
                <div>
                    <section>
                        <div className="row">
                            <div className="col-md-6 mb-3">
                                {/*<Profile/>*/}
                                <LandingCard/>
                            </div>
                            <div className="col-md-6 mb-3">
                                <LoginRegister/>
                                <LandingTestimonials/>
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