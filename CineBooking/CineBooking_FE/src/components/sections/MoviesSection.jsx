import { Card, Col, Container, Row } from 'react-bootstrap'

const nowShowing = [
  {
    title: 'Godzilla x Kong: Đế Chế Mới',
    genre: 'Hành động / Viễn tưởng',
    rating: '8.8',
    duration: '115 phút',
    poster:
      'https://images.unsplash.com/photo-1489599735188-3f5f3f1f8a8f?auto=format&fit=crop&w=600&q=80',
  },
  {
    title: 'Kung Fu Panda 4',
    genre: 'Hoạt hình / Hài',
    rating: '9.2',
    duration: '94 phút',
    poster:
      'https://images.unsplash.com/photo-1549187774-b4e9e1e7db6f?auto=format&fit=crop&w=600&q=80',
  },
  {
    title: 'Mai',
    genre: 'Tâm lý / Tình cảm',
    rating: '8.5',
    duration: '131 phút',
    poster:
      'https://images.unsplash.com/photo-1518640467707-6811f4a6ab73?auto=format&fit=crop&w=600&q=80',
  },
  {
    title: 'Exhuma: Quật Mộ Trùng Tang',
    genre: 'Kinh dị / Bí ẩn',
    rating: '9.2',
    duration: '134 phút',
    poster:
      'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=600&q=80',
  },
]

const comingSoon = [
  {
    title: 'Kingdom of the Planet of the Apes',
    release: 'Khởi chiếu 10/05/2024',
    poster:
      'https://images.unsplash.com/photo-1517604931442-7e0c8ed2963c?auto=format&fit=crop&w=600&q=80',
  },
  {
    title: 'IF: Những Người Bạn Tưởng',
    release: 'Khởi chiếu 17/05/2024',
    poster:
      'https://images.unsplash.com/photo-1542204165-65bf26472b9b?auto=format&fit=crop&w=600&q=80',
  },
  {
    title: 'Furiosa: A Mad Max Saga',
    release: 'Khởi chiếu 24/05/2024',
    poster:
      'https://images.unsplash.com/photo-1594909122845-11baa439b7bf?auto=format&fit=crop&w=600&q=80',
  },
  {
    title: 'Inside Out 2',
    release: 'Khởi chiếu 14/06/2024',
    poster:
      'https://images.unsplash.com/photo-1513106580091-1d82408b8cd6?auto=format&fit=crop&w=600&q=80',
  },
]

function SectionTitle({ title, id, href, linkLabel }) {
  return (
    <div className="section-title">
      <h2 id={id}>{title}</h2>
      <a href={href}>{linkLabel}</a>
    </div>
  )
}

function MoviesSection() {
  return (
    <section className="movies-section">
      <Container>
        <SectionTitle
          title="Phim Đang Chiếu"
          id="dang-chieu"
          href="/"
          linkLabel="Xem tất cả phim đang chiếu"
        />

        <Row className="movie-grid g-3">
          {nowShowing.map((movie) => (
            <Col key={movie.title} xs={6} lg={3}>
              <Card className="movie-card h-100">
                <div
                  className="movie-poster"
                  style={{ backgroundImage: `url(${movie.poster})` }}
                >
                  <span className="movie-rating">{movie.rating}</span>
                </div>
                <Card.Body>
                  <h3>{movie.title}</h3>
                  <p>{movie.genre}</p>
                  <div className="movie-duration">{movie.duration}</div>
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>

        <SectionTitle title="Sắp Chiếu" id="sap-chieu" href="/" linkLabel="Xem tất cả" />

        <Row className="movie-grid compact g-3">
          {comingSoon.map((movie) => (
            <Col key={movie.title} xs={6} lg={3}>
              <Card className="movie-card h-100">
                <div
                  className="movie-poster status-poster"
                  style={{ backgroundImage: `url(${movie.poster})` }}
                >
                  <span className="movie-status">Coming Soon</span>
                </div>
                <Card.Body>
                  <h3>{movie.title}</h3>
                  <div className="movie-duration">{movie.release}</div>
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>
      </Container>
    </section>
  )
}

export default MoviesSection
