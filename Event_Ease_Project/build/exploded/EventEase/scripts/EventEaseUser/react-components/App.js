'use strict';

class App extends React.Component {
	constructor() {
		super();
		this.state = {
			page: "home",

			eventList: 0,
			ticketList: 0
		}
		this.onNavigate = this.onNavigate.bind(this);
		this.llamadaAjax = this.llamadaAjax.bind(this);

	}

	onNavigate(e) {
		this.setState({
			page: e.target.name
		});
	};

	llamadaAjax(tipo) {
		const requestData = {
			tipo: tipo,
			city: "",
			date: "",
			maxPrice: 0.0
		};

		fetch('http://localhost:8080/EventEase/User', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(requestData)
		})
			.then(response => response.json())
			.then(data => {
				if (tipo == "ticket") {
					this.setState({ ticketList: data });
				}
				else {
					this.setState({ eventList: data });
				}
				// console.log('Search results:', data);
			})
			.catch(error => {
				console.error('There was an error making the request:', error);
			});
	}

	componentDidMount() {
		this.llamadaAjax();
		this.intervalId = setInterval(()=>{
			this.llamadaAjax("ticket");
			this.llamadaAjax("evento")}, 2000);
	}

	componentWillUnmount() {
		clearInterval(this.intervalId);
	}

	render() {
		let pageContent;
		switch (this.state.page) {
			case "home":
				pageContent = <HomePage color="#6aa84f" onNavigate={this.onNavigate} eventList={this.props.eventList} />;
				break;
			case "find":
				pageContent = <FindEvent onNavigate={this.onNavigate} />;
				break;
			case "current":
				pageContent = <CurrentEvents ticketList={this.props.ticketList} onNavigate={this.onNavigate} />;
				break;
			default:
				pageContent = <HomePage color="#6aa84f" onNavigate={this.onNavigate} eventList={this.props.eventList} />;
		}

		return (
			<div>
				{pageContent}
			</div>
		);
	}
}
