'use strict';

class FindEvent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            city: '',
            date: '',
            maxPrice: '',
            searchResults: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const { name, value } = event.target;
        this.setState({
            [name]: value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        // AJAX
        this.llamadaAjax("evento", this.state.city, this.state.date, this.state.maxPrice);

        console.log('Search criteria:', this.state);
    }


    llamadaAjax(tipo, city, date, maxPrice) {
        const requestData = {
            tipo: tipo,
            city: city,
            date: date,
            maxPrice: maxPrice
        };

        fetch('User', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestData)
        })
        .then(response => response.json())
        .then(data => {
            this.setState({ searchResults: data });
            // console.log('Search results:', data);
        })
        .catch(error => {
            console.error('There was an error making the request:', error);
        });
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <p style={{color: "white", border: "solid black", backgroundColor: "#085394", fontSize: "30px"}}>Look for your favourite events!</p>
                    <div>
                        <input
                            type="text"
                            name="search"
                            placeholder="search by name of Event"
                            style={{ width: '100%' }}
                        />
                    </div>
                    <div>
                        <label>
                            City <br/>
                            <select
                                name="city"
                                value={this.state.city}
                                onChange={this.handleChange}
                            >
                                <option value="">Select a city </option>
                                <option value="Madrid">Madrid</option>
                                <option value="Barcelona">Barcelona</option>
                                <option value="Valencia">Valencia</option>
                                {/* Add more cities as needed */}
                            </select>
                        </label>
                    </div>
                    <div>
                        <label>
                            Date <br/>
                            <input
                                type="date"
                                name="date"
                                value={this.state.date}
                                onChange={this.handleChange}
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            MaxPrice <br/>
                            <input
                                type="number"
                                name="maxPrice"
                                value={this.state.maxPrice}
                                onChange={this.handleChange}
                            /> €
                        </label>
                    </div>
                    <div>
                        <button type="submit">Search</button>
                    </div>
                </form>
                <EventList eventList= {this.props.searchResults}/>
            </div>
        );
    }
}

